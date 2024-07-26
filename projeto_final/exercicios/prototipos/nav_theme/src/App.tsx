// src/App.tsx
import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Navbar from './components/NavBar';


const App: React.FC = () => {
  return (
    <div>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/campanhas" element={<Campanhas />} />
        <Route path="/influencers" element={<Influencers />} />
        <Route path="/perfils" element={<Perfis />} />
      </Routes>
    </div>
  );
};

export default App;

