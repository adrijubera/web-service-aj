<xsl:stylesheet version="2.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:tns="http://tutorial2.mock_web_service"
    xmlns:ex="https://example.org/vocab#"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema#">

  <xsl:output method="text" encoding="UTF-8"/>

  <xsl:template match="/">
    @prefix ex: <https://example.org/vocab#> .
    @prefix xsd: <http://www.w3.org/2001/XMLSchema#> .

    <https://example.org/resource/inventory/1> a ex:InventoryStatus ;
        ex:status "<xsl:value-of select='//tns:getInventoryStatusResponse/tns:status'/>"^^xsd:string .
  </xsl:template>
</xsl:stylesheet>
