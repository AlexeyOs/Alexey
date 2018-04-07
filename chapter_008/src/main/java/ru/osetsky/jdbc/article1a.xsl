<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0"
  >
    <xsl:output method="xml" encoding="utf-8"/>
    <xsl:template match="entries">
        <entries>
            <xsl:apply-templates />
        </entries>
    </xsl:template>
    <xsl:template match="entry">
        <xsl:copy>
            <xsl:attribute name="field">
                <xsl:value-of select="field" />
            </xsl:attribute>
        </xsl:copy>
    </xsl:template>
</xsl:stylesheet>


