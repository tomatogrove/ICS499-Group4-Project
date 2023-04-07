/*
 * package com.team4.model;
 * 
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader; import java.util.ArrayList; import java.util.List;
 * import java.util.StringTokenizer;
 * 
 * public class UserInterface {
 * 
 * private static UserInterface userInterface; private BufferedReader reader =
 * new BufferedReader(new InputStreamReader(System.in)); private static Uno uno
 * = Uno.instance();; private static final int EXIT = 0; private static final
 * int STARTGAME = 1; private static final int HELP = 2;
 * 
 * 
 * 
 * private UserInterface() {
 * 
 * }
 * 
 * public static UserInterface instance() { if (userInterface == null) { return
 * userInterface = new UserInterface(); } else { return userInterface; } }
 * 
 * public String getToken(String prompt) { do { try {
 * System.out.println(prompt); String line = reader.readLine(); StringTokenizer
 * tokenizer = new StringTokenizer(line, "\n\r\f"); if
 * (tokenizer.hasMoreTokens()) { return tokenizer.nextToken(); } } catch
 * (IOException ioe) { System.exit(0); } } while (true); }
 * 
 * public int getNumber(String prompt) { do { try { String item =
 * getToken(prompt); Integer number = Integer.valueOf(item); return
 * number.intValue(); } catch (NumberFormatException nfe) {
 * System.out.println("Please input a number "); } } while (true); }
 * 
 * public int getCommand() { do { try { int value =
 * Integer.parseInt(getToken("Enter command:")); if (value >= EXIT && value <=
 * HELP) { return value; } } catch (NumberFormatException nfe) {
 * System.out.println("Enter a number"); } } while (true); }
 * 
 * public void help() {
 * System.out.println("Enter a number between 0 and 2 as explained below:");
 * System.out.println(EXIT + " to Exit"); System.out.println(STARTGAME +
 * " to start game"); System.out.println(HELP + " for help"); }
 * 
 * public void startGame() { int numOfPlayers =
 * getNumber("How many players: (2 - 10) players"); List<String> gamerTags = new
 * ArrayList<String>(); for(int i = 0; i < numOfPlayers; i++) {
 * gamerTags.add(getToken("Enter Player " + (i + 1) + " gamer tag")); }
 * uno.startGame(numOfPlayers, gamerTags); System.out.println("Played Card: " +
 * uno.getPlayedCard().toString()); List<Player> players =
 * uno.getPlayerList().getPlayers(); while(uno.getPlayerList().noWinner()) { int
 * n = 0; do { try { if(uno.checkIfPlayerHasPlayableHand(players.get(n))){ int
 * card = getNumber(players.get(n).myHand().toString() +
 * players.get(n).getGameTag() +
 * ", enter the number corresponding to the card you would like to play >> ");
 * uno.play(card, players.get(n)); System.out.println("Played Card: " +
 * uno.getPlayedCard().toString()); } else { System.out.println("You, " +
 * players.get(n).getGameTag() +
 * ", don't have any playable cards in your hand. We have drawn a card for you and will skip to the next player"
 * ); uno.playerDrawCard(1, players.get(n)); System.out.println("Played Card: "
 * + uno.getPlayedCard().toString()); } n++; } catch (InvalidCardException ice)
 * { System.out.println(ice.getMessage()); System.out.println("Played Card: " +
 * uno.getPlayedCard().toString()); } catch(SkipException se) {
 * System.out.println(players.get(n).getGameTag() + ", " + se.getMessage());
 * System.out.println("Played Card: " + uno.getPlayedCard().toString()); n++; }
 * catch(ReverseException re) { System.out.println(re.getMessage());
 * System.out.println("Played Card: " + uno.getPlayedCard().toString()); }
 * catch(Draw2Exception d2e) { n++;
 * System.out.println(players.get(n).getGameTag() + ", " + d2e.getMessage());
 * uno.playerDrawCard(2, players.get(n)); System.out.println("Played Card: " +
 * uno.getPlayedCard().toString()); n++; } catch(WildException we) { int
 * wildColor = getNumber(players.get(n).getGameTag() + ", " + we.getMessage());
 * switch(wildColor) { case 1: uno.getPlayedCard().setColor("Red"); break; case
 * 2: uno.getPlayedCard().setColor("Blue"); break; case 3:
 * uno.getPlayedCard().setColor("Green"); break; case 4:
 * uno.getPlayedCard().setColor("Yellow"); break; }
 * System.out.println("Played Card: " + uno.getPlayedCard().toString()); n++; }
 * catch(WildDraw4Exception wd4e) { int wildColor =
 * getNumber(players.get(n).getGameTag() + ", " + wd4e.getMessage());
 * switch(wildColor) { case 1: uno.getPlayedCard().setColor("Red"); break; case
 * 2: uno.getPlayedCard().setColor("Blue"); break; case 3:
 * uno.getPlayedCard().setColor("Green"); break; case 4:
 * uno.getPlayedCard().setColor("Yellow"); break; } n++;
 * System.out.println(players.get(n).getGameTag() + ", " +
 * wd4e.getEndingMessage()); uno.playerDrawCard(4, players.get(n));
 * System.out.println("Played Card: " + uno.getPlayedCard().toString()); n++; }
 * finally { if(n == players.size()) { n = 0; } } }
 * while(uno.getPlayerList().noWinner());
 * 
 * }
 * 
 * System.out.println("!!!Winner: " +
 * uno.getPlayerList().getWinner().getGameTag() + "!!!"); }
 * 
 * public void process() { int command; help(); while ((command = getCommand())
 * != EXIT) { switch (command) { case STARTGAME: startGame(); break; case HELP:
 * help(); break; } } }
 * 
 * public static void main(String[] args) { UserInterface.instance().process();
 * }
 * 
 * }
 */