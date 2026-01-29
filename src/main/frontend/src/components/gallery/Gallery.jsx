import React, { useEffect, useState } from 'react';

const Gallery = () => {
    const [pets, setPets] = useState([]);

    useEffect(() => {
        // This fetches from your Spring Boot backend thanks to the proxy!
        fetch('/pets')
            .then(res => res.json())
            .then(data => setPets(data))
            .catch(err => console.error("Database connection failed: ", err));
    }, []);
    return (
        <div>

    <div style={{
        display: 'grid',
        gridTemplateColumns: 'repeat(auto-fill, minmax(200px, 1fr))',
        gap: '20px',
        padding: '20px'
    }}>
        {pets.map(pet => (
            <div key={pet.id} style={{
                border: '1px solid #ddd',
                borderRadius: '8px',
                padding: '15px',
                boxShadow: '2px 2px 10px rgba(0,0,0,0.1)'
            }}>
                <h2 style={{ color: '#e67e22' }}>{pet.name}</h2>
                <p><strong>Type:</strong> {pet.petType}</p>
                <p><strong>Color:</strong> {pet.furColour}</p>
                <p><strong>Age:</strong> {pet.age} years</p>
                <p style={{ fontStyle: 'italic', fontSize: '0.9em' }}>📍 {pet.location}</p>
            </div>
        ))}
    </div>
        </div>
    )
}
export default Gallery;

