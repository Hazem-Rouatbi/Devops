import { Comment } from "./comment";

export interface Article {
    idArticle?:number;
    type:string;
    title:string;
    text:string;
    image?:string;
    comments?:Comment[];
    
}
