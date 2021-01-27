### Pre-requisites
* Java 11 or later version (must)
* Maven  
* Docker
* Docker Compose
* 8080 port must be free from where this application will be run
* Linux machine (I don't have any Windows machine to test)

### Cloning the code to your local machine

Clone this code to your local machine using the following command

```bash
git clone https://github.com/masru89xyz/initial-assessment.git
```

### Build the Application (Step:1)
Execute build-task.sh script from project's blink-tasks directory
```bash
./build-task.sh
```
### Execute Task-1 (Step:2)
Execute run-task1.sh script from project's blink-tasks directory and provide inputs one by one in a new line
```bash
./run-task1.sh
```

### Execute Task-2 (Step:3)
Execute run-task2.sh script from project's blink-tasks directory
```bash
./run-task2.sh
```
Ctrl+c to close the application

From another terminal, Just execute this curl command to test task-2 api
```bash
curl -X POST -H "Content-Type: text/plain" --data-binary @- http://localhost:8080/task23 <<EOF
2
Sun 10 May 2015 13:54:36 -0700
Sun 10 May 2015 13:54:36 -0000
Sat 02 May 2015 19:54:36 +0530
Fri 01 May 2015 13:54:36 -0000
EOF
```
### Execute Task-3 (Step:4)

Execute run-task3.sh script from project's blink-tasks directory and make sure that Task-2 application has been closed otherwise port mapping expection will be occured
```bash
./run-task3.sh
```
From another terminal, Just execute this curl command to test task-3 api 
```bash
curl -X POST -H "Content-Type: text/plain" --data-binary @- http://localhost:8080/task23 <<EOF
2
Sun 10 May 2015 13:54:36 -0700
Sun 10 May 2015 13:54:36 -0000
Sat 02 May 2015 19:54:36 +0530
Fri 01 May 2015 13:54:36 -0000
EOF
```
### Video Tutorial also available at video-tutorial directory
