package obinox.com;

import obinox.com.Enums.FurroTurnAction;
import obinox.com.Enums.MyTurnAction;
import obinox.com.Enums.Tile;
import obinox.com.Util.Pair;
import obinox.com.Util.Tenpai;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server {

    private static final int PORT = 8080;
    private static final int MAX_PLAYERS = 4;
    private static final Map<String, PrintWriter> clients = new HashMap<>();
    private static final Map<String, Player> players = new HashMap<>();
    private static final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();

    private static int clientCount = 0;
    private static int currentPlayerIndex = 0;
    private static int beforePlayerIndex = 0;
    private static boolean gameRunning = false;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started: port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Generate unique client ID
                String clientID = "Client" + clientCount++;
                clients.put(clientID, new PrintWriter(clientSocket.getOutputStream(), true));

                Player player = new Player(clientID);
                players.put(clientID, player);

                // Send welcome message
                clients.get(clientID).println("Welcome to the game!"+clientID);

                // Start game if enough players joined
                if (players.size() == MAX_PLAYERS && !gameRunning) {
                    gameRunning = true;
                    new Thread(new GameLoop()).start();
                }

                new Thread(new ClientHandler(clientSocket, clientID)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Client handler thread
    static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final String clientID;

        public ClientHandler(Socket clientSocket, String clientID) {
            this.clientSocket = clientSocket;
            this.clientID = clientID;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                // Receive messages from client
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(clientID + ": " + message);
                    messageQueue.put(clientID + ": " + message);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Remove client from game
                clients.remove(clientID);
                players.remove(clientID);
                System.out.println(clientID + " disconnected.");
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Game loop thread
    static class GameLoop implements Runnable {
        @Override
        public void run() {
            Tile ba = Tile.EAST;
            int kyoku = 1;
            int honba = 0;

            while (kyoku < 2){
                gameRunning = true;
                Yama yama = new Yama();
                Hand[] hands = new Hand[]{new Hand(), new Hand(), new Hand(), new Hand()};
                List<Pair<String, FurroTurnAction>> ableAction = new ArrayList<>();

                List<String> ableActionPlayer = new ArrayList<>();
                List<Pair<String, FurroTurnAction>> ActionPlayer = new ArrayList<>();

                Tile[][] haipais = new Tile[][]{new Tile[13], new Tile[13], new Tile[13], new Tile[13]};
                for (int k = 0; k < 3; k++) {
                    for (int h = 0; h < 4; h++) {
                        for (int i = k * 4; i < k * 4 + 4; i++) {
                            haipais[h][i] = yama.tsumo();
                        }
                    }
                }
                for (int h = 0; h < 4; h++) {
                    haipais[h][12] = yama.tsumo();
                }

                try {
                    for (int h = 0; h < 4; h++) {
                        hands[h].setKyoku(List.of(haipais[h]), ba, Tile.of(Tile.EAST.ordinal() + h));
                    }
                } catch (MahjongException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(yama.haiYama);

                // Oya tsumo
                int[] jun = new int[]{0, 0, 0, 0};
                for (PrintWriter p : clients.values()) {
                    p.println("===start");
                }
                // ===start
                // ===hand:[14]
                // ===kawa:kawa
                // ===tsumo:tsumo


                Tile giri = null;

                int[] whenRiichi = {-1,-1,-1,-1};
                ArrayList<PrintWriter> clientPrints = new ArrayList<>(clients.values());
                List<String> clientsKeySet = new ArrayList<>(clients.keySet());
                List<Integer> chiiIdx = new ArrayList<>();
                List<Tile> riichigiri = new ArrayList<>();

                int doType = 0;
                Tile tsumo = null;
                List<MyTurnAction> myTurnActions = new ArrayList<>();
                while (gameRunning) {

                    for (int i=0;i<4;i++){
                        StringBuilder s = new StringBuilder();
                        for (Tile t: hands[i].getTiles()){
                            s.append(t.str);
                        }
                        clientPrints.get(i).println("===hand:"+s);
                        for (int j=i;j<i+4;j++){
                            StringBuilder sb = new StringBuilder();
                            for (Tile t: hands[j%4].kawa){
                                sb.append(t.str);
                            }
                            if (j == currentPlayerIndex && giri != null){
                                sb.append(giri.str);
                            }
                            clientPrints.get(i).println("===kawa"+(j-i+4)%4+":"+sb);
                        }
                        StringBuilder ss = new StringBuilder();
                        for (int j=0;j<5;j++){
                            if (j<=yama.getHaiteiIdx()){
                                ss.append(yama.dorahyoujihai.get(j).str);
                            } else {
                                ss.append("0b");
                            }
                        }
                        clientPrints.get(i).println("===dora:"+ss);
                    }
                    try {
                        System.out.println(Arrays.toString(jun));
                        switch (doType) {
                            case 0 -> {
                                if (yama.isYamaEnd()){
                                    for (int i=0;i<4;i++){
                                        clientPrints.get(i).println("===gameend:");
                                    }
                                } else {
                                    tsumo = yama.tsumo();
                                    jun[currentPlayerIndex]++;
                                    hands[currentPlayerIndex].tsumo(tsumo);
                                    if (tsumo != null){
                                        clientPrints.get(currentPlayerIndex).println("===tsumo:"+tsumo.str);
                                        clientPrints.get(currentPlayerIndex).println("===input:"+0);
                                    }

                                    doType = 1;
                                }
                            }
                            case 1 -> {
                                if (hands[currentPlayerIndex].canRiichi()) {
                                    myTurnActions.add(MyTurnAction.RIICHI);
                                }
                                if (hands[currentPlayerIndex].canShouMinKan() || hands[currentPlayerIndex].canAnkan()) {
                                    myTurnActions.add(MyTurnAction.KAN);
                                }
                                if (hands[currentPlayerIndex].canTsumo()) {
                                    myTurnActions.add(MyTurnAction.TSUMO);
                                }
                                if (hands[currentPlayerIndex].canRyukyoku()) {
                                    myTurnActions.add(MyTurnAction.RYUKYOKU);
                                }
                                //test
                                myTurnActions = new ArrayList<>();
                                if (myTurnActions.isEmpty()) {
                                    doType = 2;
                                } else {
                                    clientPrints.get(currentPlayerIndex).println("Player " + currentPlayerIndex + " can do" + myTurnActions);
                                    doType = 10;
                                }
                            }
                            case 2 -> {
                                tsumo = null;
                                String message = messageQueue.take();
                                String[] parts = message.split(": ");
                                String playerID = parts[0];
                                String action = parts[1];
                                if (players.get(playerID).equals(players.values().toArray()[currentPlayerIndex])) {
                                    if (action.startsWith("===Click:")){
                                        giri = hands[currentPlayerIndex].suteru(Integer.parseInt(action.substring(9)));
                                        doType = 4;
                                    }
                                } else {
                                    System.out.println("It's not " + playerID + "'s (giri) turn.");
                                }
                            }
                            case 3 -> {

                            }
                            case 4 -> {
                                for (int i = 0; i < 4; i++) {
                                    clientPrints.get(i).println("Player " + i + " giri: " + giri);
                                }
                                for (int i = currentPlayerIndex + 1; i < currentPlayerIndex + 4; i++) {
                                    boolean b = false;
                                    if (hands[i % 4].canPong(giri)) {
                                        ableAction.add(new Pair<>(clientsKeySet.get(i % 4), FurroTurnAction.PONG));
                                        new ArrayList<>(clients.values()).get(i).println("Player " + i + "can pong");
                                        b = true;
                                    }

                                    if (hands[i % 4].canDaiminKan(giri)) {
                                        ableAction.add(new Pair<>(clientsKeySet.get(i % 4), FurroTurnAction.KAN));
                                        new ArrayList<>(clients.values()).get(i).println("Player " + i + "can kan");
                                        b = true;
                                    }
                                    if (hands[i % 4].canRon(giri)) {
                                        ableAction.add(new Pair<>(clientsKeySet.get(i % 4), FurroTurnAction.RON));
                                        new ArrayList<>(clients.values()).get(i).println("Player " + i + "can ron");
                                        b = true;
                                    }
                                    if (i == (currentPlayerIndex + 1) % 4) {
                                        if (hands[(currentPlayerIndex + 1) % 4].canChii(giri)) {
                                            ableAction.add(new Pair<>(clientsKeySet.get((currentPlayerIndex + 1) % 4), FurroTurnAction.CHII));
                                            new ArrayList<>(clients.values()).get((currentPlayerIndex + 1) % 4).println("Player " + (currentPlayerIndex + 1) % 4 + "can chii");
                                            b = true;
                                        }
                                    }
                                    if (b) {
                                        ableActionPlayer.add(clientsKeySet.get(i % 4));
                                    }
                                }
                                //Test
                                ableActionPlayer = new ArrayList<>();
                                ActionPlayer = new ArrayList<>();
                                if (ableActionPlayer.isEmpty()) {
                                    doType = 5;
                                } else {
                                    doType = 6;
                                }
                            }
                            case 5 -> {
                                hands[currentPlayerIndex].kawa.add(giri);
                                clientPrints.get(currentPlayerIndex).println("===tsumo:");
                                clientPrints.get(currentPlayerIndex).println("===input:"+1);
                                currentPlayerIndex = (currentPlayerIndex + 1) % 4;
                                giri = null;
                                doType = 0;
                            }
                            case 6 -> {
                                String message = messageQueue.take();
                                String[] parts = message.split(": ");
                                String playerID = parts[0];
                                String action = parts[1];
                                if (ableActionPlayer.contains(playerID)) {
                                    if (!Objects.equals(action, "no")) {
                                        ActionPlayer.add(new Pair<>(playerID, FurroTurnAction.of(action)));
                                    }
                                    ableActionPlayer.removeIf(p -> Objects.equals(p, playerID));
                                    ableAction.removeIf(p -> Objects.equals(p.getKey(), playerID));

                                } else {
                                    // Ignore actions from non-current player
                                    System.out.println("It's not " + playerID + "'s (furro) turn.");
                                    continue;
                                }
                                if (ableActionPlayer.isEmpty()) {
                                    if (ActionPlayer.isEmpty()) {
                                        doType = 5;
                                    } else {
                                        ActionPlayer.sort(Comparator.comparingInt(o -> o.getValue().ordinal()));
                                        beforePlayerIndex = (currentPlayerIndex + 3) % 4;
                                        currentPlayerIndex = clientsKeySet.indexOf(ActionPlayer.get(0).getKey());
                                        jun[currentPlayerIndex]++;
                                        switch (ActionPlayer.get(0).getValue()) {
                                            case RON -> {
                                                doType = 16;
                                            }
                                            case KAN -> {
                                                doType = 9;
                                            }
                                            case PONG -> {
                                                doType = 8;
                                            }
                                            case CHII -> {
                                                doType = 7;
                                            }
                                        }
                                    }
                                    ableActionPlayer = new ArrayList<>();
                                    ableAction = new ArrayList<>();
                                    ActionPlayer = new ArrayList<>();
                                }
                            }
                            case 7 -> {
                                chiiIdx = hands[currentPlayerIndex].whatChii(giri);
                                if (chiiIdx.size() > 1) {
                                    new ArrayList<>(clients.values()).get(currentPlayerIndex).println("Player " + currentPlayerIndex + " can chii" + chiiIdx);
                                    doType = -3;
                                } else {
                                    doType = -4;
                                }
                            }
                            case -3 -> {
                                String message = messageQueue.take();
                                String[] parts = message.split(": ");
                                String playerID = parts[0];
                                String action = parts[1];
                                if (players.get(playerID).equals(players.values().toArray()[currentPlayerIndex])) {
                                    hands[currentPlayerIndex].chii(giri, beforePlayerIndex, chiiIdx.get(Integer.parseInt(action)));
                                    giri = null;
                                    chiiIdx = new ArrayList<>();
                                    doType = 2;
                                } else {
                                    // Ignore actions from non-current player
                                    System.out.println("It's not " + playerID + "'s (chii) turn.");
                                    continue;
                                }
                            }
                            case -4 -> {
                                hands[currentPlayerIndex].chii(giri, beforePlayerIndex, chiiIdx.get(0));
                                giri = null;
                                chiiIdx = new ArrayList<>();
                                doType = 2;
                            }
                            case 8 -> {
                                hands[currentPlayerIndex].pong(giri, beforePlayerIndex);
                                giri = null;
                                doType = 2;
                            }
                            case 9 -> {
                                hands[currentPlayerIndex].daiminKan(giri, beforePlayerIndex);
                                giri = null;
                                doType = 15;
                            }
                            case 16 -> {
                                hands[currentPlayerIndex].ron(giri, beforePlayerIndex);
                                kyoku += 1;
                                gameRunning = false;
                            }
                            case 10 -> {
                                String message = messageQueue.take();
                                String[] parts = message.split(": ");
                                String playerID = parts[0];
                                String action = parts[1];
                                if (players.get(playerID).equals(players.values().toArray()[currentPlayerIndex])) {
                                    if (!Objects.equals(action, "no")){
                                        switch (MyTurnAction.of(action)){
                                            case TSUMO -> {
                                                doType = 13;
                                            }
                                            case KAN -> {
                                                doType = 12;
                                            }
                                            case RIICHI -> {
                                                if (!Tenpai.getTenpai(hands[currentPlayerIndex].getTiles()).isEmpty()){
                                                    riichigiri.add(tsumo);
                                                }
                                                for (int i=0;i<hands[currentPlayerIndex].getTiles().size();i++){
                                                    List<Tile> sub = new ArrayList<>(List.copyOf(hands[currentPlayerIndex].getTiles()));
                                                    sub.add(tsumo);
                                                    sub.remove(i);
                                                    if (!Tenpai.getTenpai(sub).isEmpty()){
                                                        riichigiri.add(tsumo);
                                                    }
                                                }
                                                doType = 11;
                                            }
                                            case NUKI -> {
                                                doType = 20;
                                            }
                                            case RYUKYOKU -> {
                                                doType = 14;
                                            }
                                        }
                                    } else {
                                        doType = 2;
                                    }

                                } else {
                                    System.out.println("It's not " + playerID + "'s (call) turn.");
                                }
                            }
                            case 12 -> {
                                // TODO kan select wait
                                if (hands[currentPlayerIndex].canAnkan()){
                                    hands[currentPlayerIndex].anKan();
                                } else if (hands[currentPlayerIndex].canShouMinKan()){
                                    hands[currentPlayerIndex].shouminKan();
                                }
                                doType = 15;
                            }
                            case 15 -> {
                                hands[currentPlayerIndex].tsumo(yama.rinshan());
                                doType = 1;
                            }
                            case 11 -> {
                                String message = messageQueue.take();
                                String[] parts = message.split(": ");
                                String playerID = parts[0];
                                String action = parts[1];
                                if (players.get(playerID).equals(players.values().toArray()[currentPlayerIndex])) {
                                    giri = hands[currentPlayerIndex].suteru(Integer.parseInt(action));
                                    doType = 4;
                                    riichigiri = new ArrayList<>();
                                    whenRiichi[currentPlayerIndex] = hands[currentPlayerIndex].kawa.size();
                                } else {
                                    System.out.println("It's not " + playerID + "'s (riichi) turn.");
                                }
                            }
                            case 13 -> {
                                hands[currentPlayerIndex].tsumohou();
                                kyoku += 1;
                                gameRunning = false;
                            }
                            case 14 -> {
                                kyoku += 1;
                                gameRunning = false;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }

            }
        }
    }
    // Player class
    static class Player {
        private final String id;

        public Player(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Player other = (Player) obj;
            return Objects.equals(id, other.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
