# PingPongPointManager
Write this app in Java with IntelliJ. You can start this app from src/PingPong.java.
## Thinking Process
- Start the program 
- enter names and choose who serves first 
- start the game, enter who wins for this round, also show current status like game points and who is serving 
- Someone wins 
- update leaderboard 
- how to store leaderboard 
- store it to file 
- error: Player class is not serializable
- solution: make it serializable 
- error: leaderboard can’t count the same player together, like ke: 1, ke: 1, ke: 1, I think this is because everytime we have a winner, it’s a new Player object, hashmap won’t count them together 
- solution: no need to create Player class, a string representing the name is good enough
