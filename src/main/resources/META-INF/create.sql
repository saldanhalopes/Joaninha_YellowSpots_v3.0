
USE [db_joaninha]


SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[tb_grupo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[grupo_nome] [varchar](250) NOT NULL,
	[grupo_tipo] [varchar](250) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_sh71i5m26y9p8o0w1nupotoj8] UNIQUE NONCLUSTERED 
(
	[grupo_nome] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[tb_setor](
	[setor_id] [int] IDENTITY(1,1) NOT NULL,
	[descricao_setor] [varchar](250) NULL,
	[setor] [varchar](250) NOT NULL,
	[sigla_setor] [varchar](250) NOT NULL,
	[version] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[setor_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_5axs7299k3ug36hibj6fo1u23] UNIQUE NONCLUSTERED 
(
	[setor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[tb_users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[acesso] [varchar](255) NULL,
	[change_pass] [bit] NULL,
	[computador] [varchar](255) NULL,
	[cracha] [varchar](255) NULL,
	[created] [datetime] NULL,
	[email] [varchar](255) NULL,
	[failed_access_count] [int] NULL,
	[lastlogin] [datetime] NULL,
	[lastlogout] [datetime] NULL,
	[lock] [bit] NULL,
	[name] [varchar](255) NULL,
	[pass] [varchar](255) NULL,
	[turno] [varchar](255) NULL,
	[user_computador] [varchar](255) NULL,
	[usuario] [varchar](255) NULL,
	[versao] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[tb_usuario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[change_pass] [bit] NULL,
	[computador_nome] [varchar](250) NULL,
	[computador_usuario] [varchar](250) NULL,
	[cracha] [varchar](8) NULL,
	[created] [datetime] NULL,
	[email] [varchar](250) NOT NULL,
	[failed_access_count] [int] NULL,
	[lastlogin] [datetime] NULL,
	[lastlogout] [datetime] NULL,
	[lock] [bit] NULL,
	[nome] [varchar](250) NOT NULL,
	[pass] [varchar](250) NOT NULL,
	[turno] [varchar](25) NOT NULL,
	[usuario] [varchar](250) NOT NULL,
	[version] [int] NULL,
	[grupo_id] [int] NULL,
	[setor_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_7vyj79nof99we49vtgpqn156] UNIQUE NONCLUSTERED 
(
	[usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

ALTER TABLE [dbo].[tb_usuario]  WITH CHECK ADD  CONSTRAINT [fk_grupo_usuario] FOREIGN KEY([grupo_id])
REFERENCES [dbo].[tb_grupo] ([id])

ALTER TABLE [dbo].[tb_usuario] CHECK CONSTRAINT [fk_grupo_usuario]

ALTER TABLE [dbo].[tb_usuario]  WITH CHECK ADD  CONSTRAINT [fk_setor_usuario] FOREIGN KEY([setor_id])
REFERENCES [dbo].[tb_setor] ([setor_id])

ALTER TABLE [dbo].[tb_usuario] CHECK CONSTRAINT [fk_setor_usuario]

USE [master]

ALTER DATABASE [db_joaninha] SET  READ_WRITE 

