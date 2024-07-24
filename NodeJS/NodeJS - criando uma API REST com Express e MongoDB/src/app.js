import express from "express";
import conectaNaDb from "./config/dbconnect.js";
import livro from "./model/Livro.js";

const conexao = await conectaNaDb();

conexao.on("error", (erro) => {
   console.error("erro de conexao: ", erro);
});

conexao.once("open", () => {
   console.log("conexao com o banco feita com sucesso!");
})

const app = express();
app.use(express.json()); //middleware para conversao


app.get("/", (req, res) => {
   res.status(200).send("Curso de NodeJS");
});

app.get("/livros", async (req, res) => {
   const listaLivros = await livro.find({});
   res.status(200).json(listaLivros);
});

app.get("/livros/:id", (req, res) => {
   const index = buscaLivro(req.params.id);
   res.status(200).json(livros[index]);
});

app.post("/livros", (req, res) => {
   livros.push(req.body);
   res.status(201).send("Livro cadastrado com sucesso!");
});

app.put("/livros/:id", (req, res) => {
   const index = buscaLivro(req.params.id);
   livros[index].titulo = req.body.titulo;
   res.status(200).json(livros);
});

app.delete("/livros/:id", (req, res) => {
   const index = buscaLivro(req.params.id);
   livros.splice(index, 1);
   res.status(200).send("Livro removido com sucesso!");
});

export default app;