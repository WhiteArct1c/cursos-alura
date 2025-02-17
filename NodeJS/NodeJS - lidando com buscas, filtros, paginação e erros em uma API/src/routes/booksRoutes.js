import express from "express";
import LivroController from "../controller/livroController.js";

const routes = express.Router();

routes.get("/livros", LivroController.getBooks);
routes.get("/livros/busca", LivroController.getBooksByEditora);
routes.get("/livros/:id", LivroController.getBookById);
routes.post("/livros", LivroController.registerNewBook);
routes.put("/livros/:id", LivroController.updateBook);
routes.delete("/livros/:id", LivroController.deleteBook);

export default routes;
