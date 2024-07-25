import { author } from "../model/Author.js";
import livro from "../model/Livro.js";

class LivroController {
  static async getBooks(req, res, next) {
    try {
      const listaLivros = await livro.find({});
      res.status(200).json(listaLivros);
    } catch (error) {
      next(error);
    }
  }

  static async registerNewBook(req, res, next) {
    const body = req.body;

    try {
      const authorFound = await author.findById(body.autor);
      const newBook = { ...body, autor: { ...authorFound._doc } };
      const createdBook = await livro.create(newBook);

      res
        .status(201)
        .json({ message: "Criado com sucesso!", livro: createdBook });
    } catch (error) {
      next(error);
    }
  }

  static async getBookById(req, res, next) {
    try {
      const book = await livro.findById(req.params.id);
      res.status(200).json(book);
    } catch (error) {
      next(error);
    }
  }

  static async getBooksByEditora(req, res, next) {
    const editoraBody = req.query.editora;
    try {
      const booksByEditora = await livro.find({ editora: editoraBody });
      res.status(200).json(booksByEditora);
    } catch (error) {
      next(error);
    }
  }

  static async updateBook(req, res, next) {
    try {
      await livro.findByIdAndUpdate(req.params.id, req.body);
      res.status(200).json({ message: "Livro atualizado!" });
    } catch (error) {
      next(error);
    }
  }

  static async deleteBook(req, res, next) {
    try {
      await livro.findByIdAndDelete(req.params.id);
      res.status(200).json({ message: "Livro excluído com sucesso!" });
    } catch (error) {
      next(error);
    }
  }
}

export default LivroController;
