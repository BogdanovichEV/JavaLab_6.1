<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match="Planes">
   <html>
     <body>
       <xsl:apply-templates/>
     </body>
   </html>
 </xsl:template>
<xsl:template match="plane">
  <b><xsl:value-of select="dist"/></b>
  <b><xsl:value-of select="Fuel"/></b>
  <b><xsl:value-of select="TypeName"/></b>
  <b><xsl:value-of select="type"/></b>
</xsl:template>
</xsl:stylesheet>
