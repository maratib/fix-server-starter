# Fix Server Starter


```
sudo useradd javaapp
sudo passwd javaapp

usermod -s /sbin/nologin javaapp

sudo chown javaapp:javaapp fix-0.1-server.jar 
sudo chmod 500 fix-0.1-server.jar 

sudo ln -s ~/fix1/fix-0.1-server.jar  /etc/init.d/fix-serv

sudo service fix-serv start
sudo service fix-serv stop
