USE [db_joaninha]
GO
SET IDENTITY_INSERT [dbo].[tb_grupo] ON 
GO
INSERT [dbo].[tb_grupo] ([id], [grupo_nome], [grupo_tipo]) VALUES (1, N'Admin', N'teste')
GO
SET IDENTITY_INSERT [dbo].[tb_grupo] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_setor] ON 
GO
INSERT [dbo].[tb_setor] ([setor_id], [descricao_setor], [setor], [sigla_setor], [version]) VALUES (1, N'asdfasdf', N'teste', N'te', 0)
GO
SET IDENTITY_INSERT [dbo].[tb_setor] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_usuario] ON 
GO
INSERT [dbo].[tb_usuario] ([id], [change_pass], [computador_nome], [computador_usuario], [cracha], [created], [email], [failed_access_count], [lastlogin], [lastlogout], [lock], [nome], [pass], [turno], [usuario], [version], [grupo_id], [setor_id]) VALUES (4, 1, N'asd', N'asd', N'wer', CAST(N'2018-08-19T10:29:36.000' AS DateTime), N'wer', NULL, NULL, NULL, NULL, N'1', N'op', N'1', N'123', 1, 1, 1)
GO
SET IDENTITY_INSERT [dbo].[tb_usuario] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_users] ON 
GO
INSERT [dbo].[tb_users] ([user_id], [acesso], [change_pass], [computador], [cracha], [created], [email], [failed_access_count], [lastlogin], [lastlogout], [lock], [name], [pass], [turno], [user_computador], [usuario], [versao]) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'teste', NULL)
GO
INSERT [dbo].[tb_users] ([user_id], [acesso], [change_pass], [computador], [cracha], [created], [email], [failed_access_count], [lastlogin], [lastlogout], [lock], [name], [pass], [turno], [user_computador], [usuario], [versao]) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'teste', NULL)
GO
INSERT [dbo].[tb_users] ([user_id], [acesso], [change_pass], [computador], [cracha], [created], [email], [failed_access_count], [lastlogin], [lastlogout], [lock], [name], [pass], [turno], [user_computador], [usuario], [versao]) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'teste', NULL)
GO
INSERT [dbo].[tb_users] ([user_id], [acesso], [change_pass], [computador], [cracha], [created], [email], [failed_access_count], [lastlogin], [lastlogout], [lock], [name], [pass], [turno], [user_computador], [usuario], [versao]) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'teste', NULL)
GO
INSERT [dbo].[tb_users] ([user_id], [acesso], [change_pass], [computador], [cracha], [created], [email], [failed_access_count], [lastlogin], [lastlogout], [lock], [name], [pass], [turno], [user_computador], [usuario], [versao]) VALUES (5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'teste', NULL)
GO
INSERT [dbo].[tb_users] ([user_id], [acesso], [change_pass], [computador], [cracha], [created], [email], [failed_access_count], [lastlogin], [lastlogout], [lock], [name], [pass], [turno], [user_computador], [usuario], [versao]) VALUES (6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'teste2', 0)
GO
SET IDENTITY_INSERT [dbo].[tb_users] OFF
GO
