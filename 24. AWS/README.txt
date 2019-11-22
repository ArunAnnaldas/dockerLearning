1) Create AWS Account
2) Create EC2 instance (search for docker-compose)---> Download pem file
3) Add security group once the EC2 is started
4) Note : IPv4 address
5) Navigate to downloaded pem file and run the below command from cmd
C:\Users\janar\Downloads>ssh -i ec2-user.pem ec2-user@54.225.8.85
6) Above command will give you access to the AMI machine
7) Run the below commands to check docker installation. 

[ec2-user@ip-172-31-38-90 ~]$ docker-compose -v
docker-compose version 1.22.0, build f46880fe
[ec2-user@ip-172-31-38-90 ~]$ git version
git version 2.14.5
[ec2-user@ip-172-31-38-90 ~]$ java -version
java version "1.7.0_231"
OpenJDK Runtime Environment (amzn-2.6.19.1.80.amzn1-x86_64 u231-b01)
OpenJDK 64-Bit Server VM (build 24.231-b01, mixed mode)
[ec2-user@ip-172-31-38-90 ~]$  

8) if java is not installed or correct version is not there, run the below steps to add java 8

sudo yum update -y
sudo yum remove java -y
sudo yum install java-1.8.0-openjdk -y

9) Docker, docker-compose, git, java ===> All are present in EC2 instance

10) Create an image of the EC2 instance. 

11) Goto AMI and ensure that the image is available. Terminate EC2 instance after that. 

12) Add IAM User with these rights. Please keep a note of Userid and access key (would be needed for jenkins authentication)
 AmazonEC2ReadOnlyAccess
 AmazonEC2SpotFleetAutoscaleRole
 AmazonEC2SpotFleetTaggingRole

13) Goto Jenkins, add plugin "EC2 Fleet"

14) Add global credentials in Jenkins as mentioned below: 
 
AKIARVHYVY4V43F3TS56 (jenkins-user)	AWS Credentials			jenkins-user	Update
ec2-user (ec2-user)			SSH Username with private key	ec2-user	Update

15) Created Spot instance under EC2 (ensure keypair, maintain target capacity is selected)

16) Goto Jenkins again
COnfigure SYstem -> ensure /home/ec2-user is added to root

17) Ensure other executors are set to 0

18) NOTE: The commands in jenkinsFile should be shell scripts and not bat commands. 

19) Trigger the batch job. 