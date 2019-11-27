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
| header | 4A | Parameterized value, default 0000 |
| command | 2A | Host Command |
| parameters | nA | Body / parameters for the command |

## Usage
The jar file is located inside dist directory, run as java application along with port number
```
java -jar hsm-simulator 1501
```
