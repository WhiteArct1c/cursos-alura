-- Populando a tabela Series
INSERT INTO Series (id, poster, title) VALUES
                                           (1, 'https://m.media-amazon.com/images/I/81rG9BWPPHL._AC_SY679_.jpg', 'Breaking Bad'),
                                           (2, 'https://m.media-amazon.com/images/I/81fA7eMLIPL._AC_SY679_.jpg', 'Game of Thrones'),
                                           (3, 'https://m.media-amazon.com/images/I/81oHTK5vGLL._AC_SY679_.jpg', 'Stranger Things');

-- Populando a tabela Characters
INSERT INTO Characters (id, name, serie_id) VALUES
                                                (1, 'Walter White', 1),
                                                (2, 'Jesse Pinkman', 1),
                                                (3, 'Daenerys Targaryen', 2),
                                                (4, 'Jon Snow', 2),
                                                (5, 'Eleven', 3),
                                                (6, 'Mike Wheeler', 3);

-- Populando a tabela Phrases
INSERT INTO Phrases (id, text, character_id) VALUES
                                                 (1, 'I am the one who knocks!', 1),
                                                 (2, 'Say my name.', 1),
                                                 (3, 'Yeah, science!', 2),
                                                 (4, 'I am not in danger, Skyler. I am the danger.', 1),
                                                 (5, 'I will take what is mine with fire and blood.', 3),
                                                 (6, 'When you play the game of thrones, you win or you die.', 3),
                                                 (7, 'The things I do for love.', 4),
                                                 (8, 'I don’t want it.', 4),
                                                 (9, 'Friends don’t lie.', 5),
                                                 (10, 'Mornings are for coffee and contemplation.', 6);
