import socket;

serverIP = "127.0.0.1"
serverPort = 9009
msg = "żółta gęś"

print('PYTHON UDP CLIENT')
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
client.sendto(bytes(msg, 'UTF8'), (serverIP, serverPort))


client.close()

