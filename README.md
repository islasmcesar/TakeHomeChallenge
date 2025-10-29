# TakeHomeChallenge
Proyecto de automatización para pruebas funcionales sobre la pagina https://www.mercadolibre.com   
Este proyecto se desarrollo como la primera fase de una entrevista técnica para un puesto como Ing. Automatizador de pruebas funcionales, en ella se solicitaba desarrollar una automatización de prueba funcional que cubrira los siguientes pasos:

Exercise:   
  
  •	Enter the website  
  •	Select México as a country  
  •	Search for the term “playstation 5”  
  •	Filter by condition “Nuevos”  
  •	Filter by location “Cdmx”  
  •	Order by “mayor a “menor precio”  
  •	Obtain the name and the price of the first 5 products   
  •	Print these products in the console  

## Requisitos
- Java (JDK 17 o superior) //En caso de no contar con Java instalado consultar la siguiente liga -> https://youtu.be/fESHGMFRsS0?si=fSEwAL6usQHK8i7a
- Google Chrome

## Estructura
TakeHomeChallenge/app/src
├─ main/
│  ├─ main/java/
│  │  └─ main/java/takehomechallenge/
│  └─ main/resources/
└─ test/
   ├─ test/java/
   │  ├─ test/java/Elements/
   │  │  ├─ EBasePage.java
   │  │  └─ ENavigation.java
   │  ├─ test/java/pages/
   │  │  ├─ BasePage.java
   │  │  └─ NavigationPage.java
   │  ├─ test/java/runner/
   │  │  └─ TestRunner.java
   │  ├─ test/java/steps/
   │  │  ├─ Hooks.java
   │  │  └─ NavigationSteps.java
   │  └─ test/java/utils/
   │     └─ DriverManager.java
   └─ test/resources/
      └─ test/resources/features/
         └─ TakeHomeChallenge.feature

## Ejecucion
Ejecutar el siguiente comando dentro de una terminal en la ruta del proyecto:
  ### Windows
  .\gradlew.bat clean test
  ### macOS / Linux
  ./gradlew clean test

## Reportes
Despues de cada ejecucion se encontrara el reporte correspondiente en la ruta del proyecto: TakeHomeChallenge/build/reports/cucumber.html, al abrir dicho reporte en el navegador se pueden observar en la parte inferior las imagenes correspondientes a cada paso de la ejecucion.

## Licencia
Este proyecto está licenciado bajo la Licencia [MIT] - mira el archivo LICENSE.txt para detalles.
