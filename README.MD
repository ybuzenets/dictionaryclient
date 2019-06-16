Client for dictionary server.

List of available arguments

| Argument              | Description                       | Required                |
|:---------------------:|:---------------------------------:|:-----------------------:|
| --address, --addr, -a |IP or hostname of dictionary server|No (default is 127.0.0.1)|
| --port, -p | Port number | No (default is 9000) |
| --command | Command for  the dictionary server.<br>Allowed commands are "get", "add" and "delete"| Yes |
| --args| List of comma separated arguments for specified command| Yes|

Command to send a request to the server

    java -jar dictionaryclient-0.0.1-SNAPSHOT-jar-with-dependencies.jar
     -a=dictionary.buzenets.dev -p=2323 --command=add --args Человек Human Man