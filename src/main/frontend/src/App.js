import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './components/home/Home';
import Gallery from "./components/gallery/Gallery";
import Navbar from "./components/fragments/Navbar";
import About from "./components/about/About";
import Contact from "./components/contact/Contact";

const App = () => {
    return (
        <BrowserRouter>
            <Navbar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/gallery" element={<Gallery />} />
                <Route path="/contact" element={<Contact />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;