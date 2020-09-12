package Exercise_2_Article;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author){
        this.title = title;
        this.content =content;
        this.author=author;
    }
    public void setContent(String content){
        this.content=content;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void rename (String title){
        this.title=title;
    }
    @Override
    public String toString(){
        String result = String.format("%s - %s: %s",this.title,this.content,this.author);
        return result;
    }
}
