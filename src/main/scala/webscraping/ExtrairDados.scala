package webscraping

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils


class ExtrairDados() {

  //O primeiro passa é logar na url e copiar o conteudo
  def extracaoDados(url:String): String = {
    val httpclient = HttpClients.createDefault  //Inicialização do pacote
    val httpGet = new HttpGet(url)              //Conecção com a URL
    val response = httpclient.execute(httpGet)  //Obtenção da resposta do servidor
    val entity = response.getEntity             //Chamar os metodos de resposta
    val content = EntityUtils.toString(entity)  //Obter o conteudo da pagina
    return content                              //Pronto seus dados ficam alocados no metodo
  }


}
