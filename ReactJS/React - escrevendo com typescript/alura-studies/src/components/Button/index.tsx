import React, { ReactNode } from "react";
import style from "./Button.module.scss";

interface ButtonProps {
  children: ReactNode;
  type?: "button" | "submit" | "reset" | undefined;
  onClick?: () => void;
}

class Button extends React.Component<ButtonProps> {
  render() {
    return (
      <button className={style.botao} type={this.props.type} onClick={this.props.onClick}>
        {this.props.children}
      </button>
    );
  }
}

export default Button;