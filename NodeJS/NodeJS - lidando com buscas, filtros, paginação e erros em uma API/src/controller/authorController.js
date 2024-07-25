import { author } from "../model/Author.js";

class AuthorController {
  static async getAuthors(req, res, next) {
    try {
      const authorList = await author.find({});
      res.status(200).json(authorList);
    } catch (error) {
      next(error);
    }
  }

  static async registerNewAuthor(req, res, next) {
    try {
      const newAuthor = await author.create(req.body);
      res
        .status(201)
        .json({ message: "Criado com sucesso!", autor: newAuthor });
    } catch (error) {
      next(error);
    }
  }

  static async getAuthorById(req, res, next) {
    const id = req.params.id;
    try {
      const authorFound = await author.findById(id);
      if (authorFound !== null) {
        res.status(200).json(authorFound);
      } else {
        res.status(404).json({ message: "Autor não encontrado!" });
      }
    } catch (error) {
      next(error);
    }
  }

  static async updateAuthor(req, res, next) {
    try {
      await author.findByIdAndUpdate(req.params.id, req.body);
      res.status(200).json({ message: "Autor atualizado!" });
    } catch (error) {
      next(error);
    }
  }

  static async deleteAuthor(req, res, next) {
    try {
      await author.findByIdAndDelete(req.params.id);
      res.status(200).json({ message: "Autor excluído com sucesso!" });
    } catch (error) {
      next(error);
    }
  }
}

export default AuthorController;
