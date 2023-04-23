# SprintBoot and Tesseract on Render or Railway with Web Services and Docker

## Prerequisites

* GitHub Account [https://github.com/](https://github.com/)
* Free Render Cloud Account [https://render.com/](https://render.com/) or Free Railway Cloud [https://railway.app/](https://railway.app/)
* Docker Hub Account [https://hub.docker.com/](https://hub.docker.com/)

## Required Software

* JDK 1.8+
* Maven 3.6+
* Git 2.19+
* IDE or Text Editor

## Development Hints

Local Development Machine :
>* Clone this repository from GitHub into local machine.
>* Change to the folder from cloning. You can delete the folder '.git', then initialize it again by GitHub recommendation.
>* Don't forget to run 'git add target/springboot-tesseract-render-railway-1.0.jar' before Git commit.
>* Use the command below to compile and pack the project into .jar file. 

Docker Hub :
>* Login Docker Hub, then create a repository. (optional)
>* Use a local machine (x86_64) running docker service to build an Ubuntu 20.04 image with JDK 1.8, Maven 3.6 and 
    Tesseract 4.1, then push it to Docker Hub. (optional)
>* Edit the Dockerfile file to use your own repository from Docker Hub. (if available)

GitHub :
>* Login GitHub, then create a new public repository.
>* Create one access token used for pushing any local repository to GitHub repository.
>* Use the command below to deploy the local repository to the GitHub repository.

Render Cloud : 
>* Create a web service as Docker runtime using branch main.
>* Connect the web service above to one repository of GitHub.

## How to Build

```
mvn clean package -DskipTests
```

## How to Deploy

```
git push -u origin main
```

Also login the Dashboard webpage of Render Cloud [https://dashboard.render.com/](https://dashboard.render.com/), 
choose the web service and click 'Manual Deploy' | 'Clear build cache & deploy'.


## Try at Render Cloud

With default image url

[https://springboot-tesseract-render-railway.onrender.com/](https://springboot-tesseract-render-railway.onrender.com/)
![Nature](https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Computer_modern_sample.svg/1920px-Computer_modern_sample.svg.png)

With internal image url

[https://springboot-tesseract-render-railway.onrender.com/?address=https://springboot-tesseract-render-railway.onrender.com/images/thaiconso.png](https://springboot-tesseract-render-railway.onrender.com/?address=https://springboot-tesseract-render-railway.onrender.com/images/thaiconso.png)
![Nature](https://springboot-tesseract-render-railway.onrender.com/images/thaiconso.png)

With external image url

[https://springboot-tesseract-render-railway.onrender.com/?address=https://www.media2free.com/wp-content/uploads/2022/06/laodjpg-300x88.jpg](https://springboot-tesseract-render-railway.onrender.com/?address=https://www.media2free.com/wp-content/uploads/2022/06/laodjpg-300x88.jpg)
![Nature](https://www.media2free.com/wp-content/uploads/2022/06/laodjpg-300x88.jpg)