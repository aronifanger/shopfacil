package webscraping

class GerarDados {

  def geracaoDados(url:String): List[(String, String, Float, String)] = {

    //Extrai dados da URL
    val extracao = new ExtrairDados()
    val conteudoExtracao = extracao.extracaoDados(url)

    //Transforma o conteudo extraido da URL
    val transformacao = new TransformarDados()
    transformacao.transformacaoDados(conteudoExtracao)

  }



}
