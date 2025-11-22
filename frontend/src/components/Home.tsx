import '@/components/Home.css';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
function Home() {
  const navigate = useNavigate();
  useEffect(() => {
    navigate('/post?page=1&pageSize=10', { replace: true });
  }, [navigate]);

  return null;
}

export default Home;
