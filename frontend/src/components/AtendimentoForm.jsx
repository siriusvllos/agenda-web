import React, { useState } from 'react';
import { atendimentoService } from '../services/api';

const AtendimentoForm = () => {
  const [formData, setFormData] = useState({
    data: '',
    horario: '',
    titulo: '',
    linkVideoConferencia: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await atendimentoService.inserir(formData);
      alert('Atendimento agendado com sucesso!');
      setFormData({ data: '', horario: '', titulo: '', linkVideoConferencia: '' });
    } catch (error) {
      console.error("Erro ao agendar atendimento:", error);
      alert('Erro ao agendar. Verifique o console ou se o backend está rodando.');
    }
  };

  return (
    <div style={{ maxWidth: '400px', margin: '0 auto', border: '1px solid #ccc', padding: '20px', borderRadius: '8px' }}>
      <h2>Agendar Atendimento</h2>
      <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>
        
        <label>Título:</label>
        <input type="text" name="titulo" value={formData.titulo} onChange={handleChange} required />

        <label>Data:</label>
        <input type="date" name="data" value={formData.data} onChange={handleChange} required />

        <label>Horário:</label>
        <input type="time" name="horario" value={formData.horario} onChange={handleChange} required />

        <label>Link da Videoconferência:</label>
        <input type="url" name="linkVideoConferencia" value={formData.linkVideoConferencia} onChange={handleChange} />

        <button type="submit" style={{ marginTop: '10px', padding: '10px', cursor: 'pointer' }}>Agendar</button>
      </form>
    </div>
  );
};

export default AtendimentoForm;