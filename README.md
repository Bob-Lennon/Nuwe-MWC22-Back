
# 4FYN (MWC 2022) Hackathon by Nuwe

The MWC is a technological showcase for companies and talent. So, we are going to play with the data and information from the Barcelona Digital Talent event. 

> The aim is to create a CLI that allows developers to access information about the MWC and other developers and tech professionals who will be attending.

#
![](https://img.shields.io/github/last-commit/Bob-Lennon/Nuwe-MWC22-Back) ![](https://img.shields.io/github/followers/Bob-Lennon?style=social)

## Technology Stack
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)

The [Picocli](https://github.com/remkop/picocli) library was also used.

#### Tools
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white) ![Spotify](https://img.shields.io/badge/Spotify-1ED760?style=for-the-badge&logo=spotify&logoColor=white) ![Stack Overflow](https://img.shields.io/badge/-Stackoverflow-FE7A16?style=for-the-badge&logo=stack-overflow&logoColor=white)

The [Lombok](https://projectlombok.org/) library was also used to speed up the development process.

## Tasks
✅ Task 1 → Create a developer template containing the following information: Name, Email, Category ( Front, Back, Mobile, Data), Phone, Days to attend mobile ( Feb 28, March 1 -3)

✅ Task 2 → Insert the data from the .json into a database (Link to the json in the statement)

✅ Task 3 → Generate a CLI command to display the MWC information (Days to be available)

✅ Task 4 → Generate a CLI command to display the list of developers

✅ Task 5 → Generate a CLI command that allows to add a new developer and update the database

## Usage
For this demonstration we will make use of the Java I/O libraries to use a console menu:
![Menu](https://i.imgur.com/TNcSllk.png)

#### Developer
Adding a developer to the list.
![Add](https://imgur.com/f8aWand.png)

#### Notes
For the 2nd task, the json file is added to the project directory to automatically insert the data into the local MySQL database of the current local machine to the next URL.

> localhost:3306/mwc22, user: root & password: 1234
