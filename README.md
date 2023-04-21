# SprintBoot and Tesseract on Render or Railway with Web Services and Docker

## How to Build

```
mvn clean package -DskipTests
```

## How to Deploy

```
git push -u origin main
```

## Try at Render Cloud

Without image url (address=https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Computer_modern_sample.svg/1920px-Computer_modern_sample.svg.png)

```
https://springboot-tesseract-render-railway.onrender.com/
```

With internal image url(address=https://springboot-tesseract-render-railway.onrender.com/images/thaiconso.png)

```
https://springboot-tesseract-render-railway.onrender.com/?address=https://springboot-tesseract-render-railway.onrender.com/images/thaiconso.png
```

With external image url (address=https://www.media2free.com/wp-content/uploads/2022/06/laodjpg-300x88.jpg)

```
https://springboot-tesseract-render-railway.onrender.com/?address=https://www.media2free.com/wp-content/uploads/2022/06/laodjpg-300x88.jpg
```
