package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Destinos;

public class DestinosDAO {
	public void save(Destinos destino) {
		String sql;

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			sql = destino.getIdDestino() == 0 ? 
					"insert into Destino (nomeDestino, avaliacao) values (?, ?)"
					:
					"UPDATE Destino SET nomeDestino = ?, avaliacao = ? WHERE idDestino = ?"	
					;
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNomeDestino());
			pstm.setInt(2, destino.getAvaliacao());
			if (destino.getIdDestino() != 0 ) {
				pstm.setInt(3, destino.getIdDestino());
			}
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Destinos> read() {
		List<Destinos> destinos = new ArrayList<Destinos>();
		String sql = "select * from Destino";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Destinos destino = new Destinos();

				destino.setIdDestino(rset.getInt("idDestino"));
				destino.setNomeDestino(rset.getString("nomeDestino"));
				destino.setAvaliacao(rset.getInt("avaliacao"));

				destinos.add(destino);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return destinos;
	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Destino WHERE idDestino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Destinos readById(int id) {
		Destinos destino = new Destinos();
		String sql = "select * from Destino WHERE idDestino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			destino.setIdDestino(rset.getInt("idDestino"));
			destino.setNomeDestino(rset.getString("nomeDestino"));
			destino.setAvaliacao(rset.getInt("avaliacao"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return destino;
	}

}
