import '@/App.css';
import Home from '@/components/Home';
import { Routes, Route } from 'react-router-dom';
import Editor from '@/components/Editor';
import Page from '@/components/Page';

const App = () => {
  return (
    <div className="app">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/edit/:id" element={<Editor />} />
          <Route path="/post" element={<Page />} />
        </Routes>
    </div>
  );
};

export default App;
