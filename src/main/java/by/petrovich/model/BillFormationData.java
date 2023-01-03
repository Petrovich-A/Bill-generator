package by.petrovich.model;

import java.util.List;

public class BillFormationData {
    private String header;
    private String delimiterLine;
    private List<String> productRows;
    private String totalFooter;

    public BillFormationData(String header, String delimiterLine, List<String> productRows, String totalFooter) {
        this.header = header;
        this.delimiterLine = delimiterLine;
        this.productRows = productRows;
        this.totalFooter = totalFooter;
    }

    public BillFormationData() {

    }

    public String getHeader() {
        return header;
    }

    public BillFormationData setHeader(String header) {
        this.header = header;
        return this;
    }

    public String getDelimiterLine() {
        return delimiterLine;
    }

    public BillFormationData setDelimiterLine(String delimiterLine) {
        this.delimiterLine = delimiterLine;
        return this;
    }

    public List<String> getProductRows() {
        return productRows;
    }

    public BillFormationData setProductRows(List<String> productRows) {
        this.productRows = productRows;
        return this;
    }

    public String getTotalFooter() {
        return totalFooter;
    }

    public BillFormationData setTotalFooter(String totalFooter) {
        this.totalFooter = totalFooter;
        return this;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getHeader());
        stringBuffer.append(this.getDelimiterLine());
        this.getProductRows().forEach(row -> stringBuffer.append(row));
        stringBuffer.append(this.getDelimiterLine());
        stringBuffer.append(this.getTotalFooter());
        return stringBuffer.toString();
    }
}
