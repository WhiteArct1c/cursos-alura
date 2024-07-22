import { ReactNode } from "react";
import style from "./Button.module.scss";

interface ButtonProps {
  children: ReactNode;
  type?: "button" | "submit" | "reset" | undefined;
  onClick?: () => void;
}

function Button({ children, type, onClick }: ButtonProps) {
    return (
      <button className={style.botao} type={type} onClick={onClick}>
        {children}
      </button>
    );
}

export default Button;