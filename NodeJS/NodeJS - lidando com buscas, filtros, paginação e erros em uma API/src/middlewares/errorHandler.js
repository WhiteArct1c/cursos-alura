import mongoose from "mongoose";

// eslint-disable-next-line no-unused-vars
function errorHandler(err, req, res, next) {
  if (err instanceof mongoose.Error.CastError) {
    res.status(400).json({
      message: "Um ou mais dados informados estão mal formatados ou incorretos",
    });
  } else if (err instanceof mongoose.Error.ValidationError) {
    const errorsMessage = Object.values(err.errors)
      .map((error) => error.message)
      .join(", ");
    res.status(400).json({
      message: `Os seguintes erros foram encontrados: ${errorsMessage}`,
    });
  } else {
    res.status(500).json({ message: "Erro interno do servidor" });
  }
}

export default errorHandler;
