package principal


import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}
import webscraping.GerarDados

object Principal {

  def main(args: Array[String]): Unit = {


    """
      |create table goal_sku (
      |    customer: decimal(18,0),
      |    goal: decimal(20,0),
      |    sku: string
      |    )
    """.stripMargin


    val sku = Range(4635192, 4635199)
    val url = "http://shopfacil.vtexcommercestable.com.br/api/catalog_system/pub/products/search/?fq=skuId:"

    //Gerarção de dados WEB
    val dados = new GerarDados()
    val resultado = sku.flatMap(s => dados.geracaoDados(url + s)) //Gerando dados para cada SKU da lista, o resultado final é uma lista

    //Inicialização do Spark
    val sparkConf: SparkConf = new SparkConf().setAppName("webScraping").setMaster("local")
    val sc = new SparkContext(sparkConf)

    //Inicialização do Hive
    val hive = new HiveContext(sc) //Inicialização depende da inicializalçao do Spark
    val warehouse = "/home/vinicius/Projetos/Hive/" //Caminho qual está configurado para salvar o banco de dados
    hive.setConf("hive.metastore.warehouse.dir", warehouse) //Informando caminho para o hive


    //Criação do DataFrame
    val rdd = sc.parallelize(resultado)
    val dfOriginal = hive.createDataFrame(rdd)
    val df = dfOriginal //Filtrar neste data frame se necessário


    //Carregamento no hive
    df.registerTempTable("temp")
    df.write.mode("overwrite").saveAsTable("temp")
    hive.sql("CREATE DATABASE IF NOT EXISTS webscraping")
    hive.sql("DROP TABLE shopfacil")
    hive.sql("CREATE TABLE IF NOT EXISTS shopfacil (ITEM STRING, SELLER STRING, PRICE FLOAT, DATA STRING)")
    hive.sql("insert into table shopfacil select * from temp")
    hive.sql("select * from shopfacil").show()



  }




}
