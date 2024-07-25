import { author } from "../model/Author.js";

class AuthorController {
  static async getAuthors(req, res) {
    try {
      const authorList = await author.find({});
      res.status(200).json(authorList);
    } catch (error) {
      res
        .status(500)
        .json({ message: `${error.message} - falha ao listar autores` });
    }
  }

  static async registerNewAuthor(req, res) {
    try {
      const newAuthor = await author.create(req.body);
      res
        .status(201)
        .json({ message: "Criado com sucesso!", autor: newAuthor });
    } catch (error) {
      res
        .status(500)
        .json({ message: `${error.message} - falha ao cadastrar autor` });
    }
  }

  static async getAuthorById(req, res) {
    try {
      const author = await author.findById(req.params.id);
      res.status(200).json(author);
    } catch (error) {
      res
        .status(500)
        .json({ message: `${error.message} - falha ao procurar o autor` });
    }
  }

  static async updateAuthor(req, res) {
    try {
      await author.findByIdAndUpdate(req.params.id, req.body);
      res.status(200).json({ message: "Autor atualizado!" });
    } catch (error) {
      res
        .status(500)
        .json({ message: `${error.message} - falha ao atualizar o autor` });
    }
  }

  static async deleteAuthor(req, res) {
    try {
      await author.findByIdAndDelete(req.params.id);
      res.status(200).json({ message: "Autor excluído com sucesso!" });
    } catch (error) {
      res
        .status(500)
        .json({ message: `${error.message} - falha ao excluir o autor` });
    }
  }
}

export default AuthorController;
