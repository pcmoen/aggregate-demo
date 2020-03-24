# aggregate-demo
Demo for å vise OneToMany casecade for bruk med agregerte røtter.

## demo-naive
Viser naive bruk, den har minst kode men er sårbar for at noen leker med dataene. For eksempel å flytte et sete fra en vogn til en annen (for eksempel for å sabotere).

## demo.in-service
Viser endringer hvor man gjør endringene i en service. Den er trygg for at brukeren ikke flytter sete eller kupeer mellom forskjellige vogner.

## demo.in-jpaentity 
Flyttet jeg koden fra service til selve jpa-entiteten. Bare for å vise at koden også kan ligge der.

## demo.in-jpaentity-med-validation
Siste eksempel er med validering.