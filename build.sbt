name := "webscraping"

version := "0.1"

scalaVersion := "2.10.5"

//Biblioteca faz a conecção com a web para o webscraping
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.5"

//Biblioteca para tratativa de arquivos no formato Json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.8"
libraryDependencies +=   "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.9" //Componente está desatualizado no spark 1.6, necessário para o play-framework


//Bibliotecas para utilização do Spark
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.1"
libraryDependencies += "org.apache.spark" %% "spark-sql"  % "1.6.1"

//Biblioteca para conecção com Banco Hive
libraryDependencies += "org.apache.spark" %% "spark-hive" % "1.6.1"

//Scala teste
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4"
