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
      try {
         const newBook = await livro.create(req.body);
         res.status(201).json({message: "Criado com sucesso!", livro: newBook});
      } catch (error) {
         res
            .status(500)
            .json({ message: `${error.message} - falha ao cadastrar livro`});
      }
   }

   static async getBookDetails(req, res){
      try {
         const book = await livro.findById(req.params.id);
         res.status(200).json(book);
      } catch (error) {
         res
            .status(500)
            .json({ message: `${error.message} - falha ao procurar o livro`});
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