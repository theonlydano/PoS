public class UrlEncoder {
    private String url = "";
    private String encodedUrl;

    public UrlEncoder(){

    }
    public void encode(){
        if(url == ""){
            System.out.println("Error - there is no url!");
        }
        encodedUrl = url;
        encodedUrl = encodedUrl.replace("%", "%25");
        encodedUrl = encodedUrl.replace("_", "%20");
        encodedUrl = encodedUrl.replace("!", "%21");
        encodedUrl = encodedUrl.replace("#", "%23");
        encodedUrl = encodedUrl.replace("$", "%24");
        encodedUrl = encodedUrl.replace("&", "%26");
        encodedUrl = encodedUrl.replace("'", "%27");
        encodedUrl = encodedUrl.replace("(", "%28");
        encodedUrl = encodedUrl.replace(")", "%29");
        encodedUrl = encodedUrl.replace("*", "%2A");
        encodedUrl = encodedUrl.replace("+", "%2B");
        encodedUrl = encodedUrl.replace(",", "%2C");
        //encodedUrl = encodedUrl.replace("-", "%2D");
        //encodedUrl = encodedUrl.replace(".", "%2E"); ist bei Ihnen nicht includiert
        encodedUrl = encodedUrl.replace("/", "%2F");
        encodedUrl = encodedUrl.replace(":", "%3A");
        encodedUrl = encodedUrl.replace(";", "%3B");
        encodedUrl = encodedUrl.replace("<", "%3C");
        encodedUrl = encodedUrl.replace("=", "%3D");
    }
    public String getEncodedUrl(){
        return encodedUrl;
    }
    public String getUrl(){
        return url;
    }
    public static void main(String[] args){
        UrlEncoder ue = new UrlEncoder();
        String url = "https://www.htl-kaindorf.at";
        ue.setUrl(url);
        ue.encode();
        System.out.println(ue.getEncodedUrl());
    }
    public void setUrl(String url){
        this.url = url;
    }
}
