import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './commande.reducer';

export const CommandeDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const commandeEntity = useAppSelector(state => state.commande.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="commandeDetailsHeading">
          <Translate contentKey="aaaApp.commande.detail.title">Commande</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{commandeEntity.id}</dd>
          <dt>
            <span id="listeArticle">
              <Translate contentKey="aaaApp.commande.listeArticle">Liste Article</Translate>
            </span>
          </dt>
          <dd>{commandeEntity.listeArticle}</dd>
          <dt>
            <span id="heureDeCommande">
              <Translate contentKey="aaaApp.commande.heureDeCommande">Heure De Commande</Translate>
            </span>
          </dt>
          <dd>{commandeEntity.heureDeCommande}</dd>
          <dt>
            <span id="paiement">
              <Translate contentKey="aaaApp.commande.paiement">Paiement</Translate>
            </span>
          </dt>
          <dd>{commandeEntity.paiement}</dd>
          <dt>
            <Translate contentKey="aaaApp.commande.restaurant">Restaurant</Translate>
          </dt>
          <dd>
            {commandeEntity.restaurants
              ? commandeEntity.restaurants.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {commandeEntity.restaurants && i === commandeEntity.restaurants.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
          <dt>
            <Translate contentKey="aaaApp.commande.client">Client</Translate>
          </dt>
          <dd>{commandeEntity.client ? commandeEntity.client.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/commande" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/commande/${commandeEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default CommandeDetail;
