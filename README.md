# hsm-simulator
A Java base app that simulate HSM Thales Payshield 9000, with limited command available of course :D

## Available Command
1. NC (Currently available)
2. A0
3. CC

## Message Format
| Field | Length | Desc |
| ------ | ------ | ------ |
| mli | 4H | Message length indicator |
| header | 4A | Parameterized value, not use if omit |
| command | 2A | Host Command |
| parameters | nA | Body / parameters for the command |
## Message Example
Suppose you want to send NC command, the server set header value is 0000. The original message will be.
> 0000NC

Then you have to convert to hex string, the result are.
> 303030304e43

Before send to hsm, you have to calculate message length, for above message, the length in decimal is 6.
Therefor you have to convert to hex 4 digit with zero padding.
> Convert to Hex 6 -> 6
> Padding 0 > 0006 

The final message will look like,
> 0006303030304e43

## Usage
The jar file is located inside dist directory, run as java application along with port number and header value
```
java -jar hsm-simulator 1501 0000
```
