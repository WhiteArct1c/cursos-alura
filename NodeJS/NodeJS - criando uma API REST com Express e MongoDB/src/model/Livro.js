import mongoose from "mongoose";

const livroSchema = new mongoose.Schema({
   id: { type: mongoose.Schema.Types.ObjectId },
   titulo: { type: String, required: true },
   editora: { type: String },
   preco: { type: Number },
   paginas: { type: Number }
}, { versionKey: false }); // cria o schema do coleção

const livro = mongoose.model("livros", livroSchema); // cria o modelo baseado no schema

export default livro; //exporta o modelo