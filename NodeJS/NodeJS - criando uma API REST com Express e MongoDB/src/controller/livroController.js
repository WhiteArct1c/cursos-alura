import { author } from "../model/Author.js";
import livro from "../model/Livro.js";

class LivroController {
   
   static async getBooks(req ,res){
      try{
         const listaLivros = await livro.find({});
         res.status(200).json(listaLivros);
      }catch(error){
         res
            .status(500)
            .json({ message: `${error.message} - falha ao listar livros`});
      }
   }

   static async registerNewBook (req, res){
      const body = req.body;
      
      try {

         const authorFound = await author.findById(body.autor);
         const newBook = {...body, autor: {...authorFound._doc}};
         const createdBook = await livro.create(newBook);

         res.status(201).json({message: "Criado com sucesso!", livro: createdBook});
      } catch (error) {
         res
            .status(500)
            .json({ message: `${error.message} - falha ao cadastrar livro`});
      }
   }

   static async getBookById(req, res){
      try {
         const book = await livro.findById(req.params.id);
         res.status(200).json(book);
      } catch (error) {
         res
            .status(500)
            .json({ message: `${error.message} - falha ao procurar o livro`});
      }
   }

   static async getBooksByEditora(req, res) {
      const editoraBody = req.query.editora;
      try {
         const booksByEditora = await livro.find({ editora: editoraBody });
         res.status(200).json(booksByEditora);
      } catch (error) {
         res
            .status(500)
            .json({ message: `${error.message} - falha ao procurar o livro por editora`});
      }
   }

   static async updateBook(req, res){
      try {
         await livro.findByIdAndUpdate(req.params.id, req.body);
         res.status(200).json({message: "Livro atualizado!"});
      } catch (error) {
         res
            .status(500)
            .json({ message: `${error.message} - falha ao atualizar o livro`});
      }
   }

   static async deleteBook(req, res){
      try {
         await livro.findByIdAndDelete(req.params.id);
         res.status(200).json({message: "Livro excluído com sucesso!"});
      } catch (error) {
         res
            .status(500)
            .json({ message: `${error.message} - falha ao excluir o livro`});
      }
   }

};

export default LivroController;