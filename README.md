# mcDiscordBot
**dependencies** (version can be change in the pom.xml)
 - JDA-5.0.0-beta.6
 - spigot-1.8.8-R0.1-SNAPSHOT 

maven projet

## BUILD Jar FILE
```bash
mvn package
```
or use the `package.cmd`
require maven with 3.8.1 build version

## DEFAULT CONFIGURATION

first use in plugin in a spigot or paper server!
![image](https://user-images.githubusercontent.com/67376828/227264156-961d08f4-21e0-4ef5-a05f-434614e54795.png)

**for fix you must create `your bot discord` and go to the 'config.yml' in plugin folder.**

config.yml :
```yaml
#if token change the plugin must be restart
Token: 'token'

TextChannelID: 'id'

OnableVocalChannelInfoID: 'false'
VocalChannelInfoID: 'id'

Command-permission: 'discord.use'
```

change with own information

