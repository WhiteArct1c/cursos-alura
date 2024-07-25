import globals from "globals";
import pluginJs from "@eslint/js";
import eslintConfigPrettier from "eslint-config-prettier";

export default [
  {
    languageOptions: {
      globals: {
        ...globals.browser,
        ...globals.node,
      },
    },
    rules: {
      "no-unused-vars": "error",
      "no-undef": "error",
      semi: ["error", "always"], // Garante o uso de ponto e vírgula
      "prefer-const": "error",
      quotes: ["error", "double", { allowTemplateLiterals: true }],
      indent: ["error", "tab"],
    },
  },
  eslintConfigPrettier,
  pluginJs.configs.recommended,
];
