import express from "express";
import conectaNaDb from "./config/dbconnect.js";
import routes from "./routes/index.js";

const conexao = await conectaNaDb();

conexao.on("error", (erro) => {
  console.error("erro de conexao: ", erro);
});

conexao.once("open", () => {
  console.log("conexao com o banco feita com sucesso!");
});

const app = express();
routes(app);

export default app;
