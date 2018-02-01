import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import webscraping.ExtrairDados

object WebScrapingLink {


//  def call(skus: List[Int]) = {
//    val url = "http://shopfacil.vtexcommercestable.com.br/api/catalog_system/pub/products/search/?fq=skuId:"
//
//    val dados = new ExtrairDados()
//    skus.map(l => auxWebScraping(url + l)).foreach(println)
//  }

  def main(args: Array[String]): Unit = {

    val sku: List[Int] = List(4635192, 4635198, 1231, 123123, 123123, 312312)

    //val groupedSku: List[List[Int]] = sku.grouped(4).toList

    //groupedSku.foreach(call)

    val url = "http://shopfacil.vtexcommercestable.com.br/api/catalog_system/pub/products/search/?fq=skuId:"

    val dados = new ExtrairDados()
    sku.map(l => auxWebScraping(url + l)).foreach(println)

  }

  def auxWebScraping(url_sku:String): Unit ={
    val httpclient = HttpClients.createDefault  //Inicialização do pacote
    val httpGet = new HttpGet(url_sku)              //Conecção com a URL
    val response = httpclient.execute(httpGet)  //Obtenção da resposta do servidor
    response
  }


}
