SRC=src
BIN=bin
LIB=lib

CLIENTFOLDER=client
SERVERFOLDER=server

FILEMAINCLIENT=Main
FILEMAINSERVER=server
FILE_LIB_00001=org.json_8.0.0.201902231800.jar

BACKUPFOLDER=Case-Study_developer_Java

all: $(CLIENTFOLDER)/$(SRC)/$(FILEMAINCLIENT).java $(SERVERFOLDER)/$(SRC)/$(FILEMAINSERVER).py
	javac -cp ".:$(LIB)/$(FILE_LIB_00001)" -d $(BIN)/$(CLIENTFOLDER) $(CLIENTFOLDER)/$(SRC)/*.java	

clean: $(SERVERFOLDER)/$(SRC)/$(FILEMAINSERVER).py	$(BIN)/$(CLIENTFOLDER)/*.class	
	rm $(BIN)/$(CLIENTFOLDER)/*.class	
	rm -R $(BIN)

client: $(BIN)/$(CLIENTFOLDER)/*.class
	java -classpath $(BIN)/$(CLIENTFOLDER)/:".:$(LIB)/$(FILE_LIB_00001)" $(FILEMAINCLIENT)	

server: $(SERVERFOLDER)/$(SRC)/$(FILEMAINSERVER).py
		python3 $(SERVERFOLDER)/$(SRC)/$(FILEMAINSERVER).py
update_backup:	
	cp -R $(CLIENTFOLDER)/$(SRC)/*.java $(BACKUPFOLDER)/$(CLIENTFOLDER)/$(SRC)
	cp -R $(SERVERFOLDER)/$(SRC)/*.py $(BACKUPFOLDER)/$(SERVERFOLDER)/$(SRC)		
	cp "$(LIB)/$(FILE_LIB_00001)" $(BACKUPFOLDER)/$(LIB)